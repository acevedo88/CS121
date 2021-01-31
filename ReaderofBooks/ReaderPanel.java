import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/*CS 121 #3 Project 4: ReaderOfBooks
* 
* This program uses a Graphical User Interface that will allow the user to input a .csv file which contains a list
* of Books.  The user can select a book once uploaded and read its texts which is displayed on another panel.  The
* interface displays the book information on top and the page number the user is currently on.  There are Navigation
* buttons that allow the user to go up or down a page if they wish to do so.
* 
* @author Alex Acevedo
* Fall 2018
*/

public class ReaderPanel extends JPanel{

	//Sets variables to be globally used
	JTextArea contentPane;
	JPanel infoPane;
	JScrollPane contentScrollPane;
	JPanel navPane;
	JLabel title;
	JLabel by;
	JLabel page;
	JButton pageUp;
	JButton pageDown;
	JScrollBar scrollBar;


	public ReaderPanel(String name)
	{

		//Sets the main layout of the panel and its label
		setLayout(new BorderLayout());
		this.setBackground(Color.cyan);
		this.setBorder(BorderFactory.createTitledBorder("Reader"));

		//Creates a new panel that will have the book information displayed into it
		infoPane = new JPanel();
		infoPane.setBackground(Color.green);
		infoPane.setBorder(BorderFactory.createTitledBorder("Information"));

		//Labels that the information panel will use
		title = new JLabel();
		by = new JLabel();
		page = new JLabel();

		title.setText("Title: " );
		by.setText("By:  ");
		page.setText("Page: ");

		infoPane.add(title);
		infoPane.add(by);
		infoPane.add(page);
		add(infoPane, BorderLayout.NORTH);

		//Creates the text area the book's text field will be displayed at.  
		contentPane = new JTextArea();
		contentPane.setAlignmentY(CENTER_ALIGNMENT);
		contentPane.setEditable(false);

		//Creates and uses the text area to make a scroll pane for the user to view all the texts in the book
		contentScrollPane = new JScrollPane(contentPane);
		contentScrollPane.setBackground(Color.red);
		contentScrollPane.setBorder(BorderFactory.createTitledBorder("Content"));
		contentScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		contentScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//Creates a scroll bar the will use a listener to get information for
		scrollBar = contentScrollPane.getVerticalScrollBar();
		scrollBar.addAdjustmentListener(new ScrollAdjustmentListener());

		add(contentScrollPane, BorderLayout.CENTER);

		//Creates a panel for the page up and down buttons that will have listeners attached to them
		navPane = new JPanel();
		navPane.setBackground(Color.cyan);
		navPane.setBorder(BorderFactory.createTitledBorder("Navigation"));
		pageUp = new JButton("Page Up");
		pageUp.addActionListener(new PageUpListener());
		pageDown = new JButton("Page Down");
		pageDown.addActionListener(new PageDownListener());
		navPane.add(pageUp);
		navPane.add(pageDown);
		add(navPane, BorderLayout.SOUTH);



	}

	
	//Listener for the scroll bar adjustment
	private class ScrollAdjustmentListener implements AdjustmentListener {
		@Override
		
		public void adjustmentValueChanged(AdjustmentEvent arg0) {
			
			//integers that will get information from the scroll bar and set values for the book pages
			int pageLength = scrollBar.getBlockIncrement(1);
			int maximumLength = scrollBar.getMaximum();
			int pageCount = maximumLength/pageLength;
			int scrollPosition = scrollBar.getValue();
			int pageNumber = (scrollPosition/pageLength)+1;
			page.setText("Page: "+pageNumber+"/"+pageCount);
			
			//If states the enable or disable page buttons if scroll is on top or bottom
			if(pageNumber == 1)
			{
				pageUp.setEnabled(false);
			}
			else
				pageUp.setEnabled(true);
			
			if(pageNumber == pageCount)
			{
				pageDown.setEnabled(false);
			}
			else
				pageDown.setEnabled(true);
		}
	}

	//Page up button listener
	private class PageUpListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			System.out.println("Clicked");

			int pageLength = scrollBar.getBlockIncrement(1);
			int scrollPosition = scrollBar.getValue();
			
			scrollBar.setValue(scrollPosition-pageLength);

		}
	}

	//Page down listener
	private class PageDownListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("Clicked");

			int pageLength = scrollBar.getBlockIncrement(1);
			int scrollPosition = scrollBar.getValue();
			
			scrollBar.setValue(scrollPosition+pageLength);


		}
	}

}

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

// imported necessary packages and libraries

public class Scribble extends JFrame {
	static int last_x, last_y; // coordinates of pointer
	static JButton clear; // button
	static JComboBox clr; // list of choices

	static Color curr_color = Color.black; // current color

	Scribble() {
		last_x = last_y = 0;
	}

	public static void main(String args[]) {

		JFrame f = new JFrame("Scribble Game");
		clear = new JButton("Clear");
		clear.setBackground(Color.lightGray); // add background & foreground color to button
		clear.setForeground(Color.black);

		// provide different color options to user

		String colors[] = { "blue", "red", "yellow", "green", "magenta", "pink", "orange" ,"black" };

		// added different colors to clr

		clr = new JComboBox<>(colors);
		clr.updateUI();

		f.setSize(1000, 500); // setting up frame paramters
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setLayout(new FlowLayout());
		f.add(new Label("Color: ")); // adding all components to the frame container
		f.add(clr);
		f.add(clear);

		f.addMouseListener(new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {             // function called when mouse is pressed
				last_x = e.getX();
				last_y = e.getY();

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

		});

		f.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(java.awt.event.MouseEvent e) {             // function called when mouse is pressed and dragged
				Graphics g = f.getGraphics();
				g.setColor(curr_color);
				g.drawLine(last_x, last_y, e.getX(), e.getY());
				last_x = e.getX();
				last_y = e.getY();

			}

			@Override
			public void mouseMoved(MouseEvent e) {
				
			}

		});

		clear.addActionListener(new ActionListener() {         // if "clear" is pressed then this function is called
			public void actionPerformed(ActionEvent e) {
				Graphics g = f.getGraphics();
				Rectangle r = f.getBounds();
				g.setColor(f.getBackground());
				g.fillRect(r.x, r.y, r.width, r.height);
			}
		});

		clr.addItemListener(new ItemListener() {                  // if any color from clr is selected then this is called
			public void itemStateChanged(ItemEvent event) {
				if (event.getStateChange() == ItemEvent.SELECTED) {
					Object item = event.getItem();
					if (item.equals("red"))
						curr_color = Color.red;
					else if (item.equals("yellow"))
						curr_color = Color.yellow;
					else if (item.equals("blue"))
						curr_color = Color.blue;
					else if (item.equals("green"))
						curr_color = Color.green;
					else if (item.equals("magenta"))
						curr_color = Color.magenta;
					else if (item.equals("orange"))
						curr_color = Color.orange;
					else if (item.equals("pink"))
						curr_color = Color.pink;
					else if (item.equals("black"))
						curr_color = Color.black;

				}
				else f.setVisible(true);
			}
		});
	}
}

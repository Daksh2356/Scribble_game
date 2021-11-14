import java.applet.*;
import java.awt.*;

public class Scribble extends Applet  
{
	private int last_x,last_y;
	private  Button clear;
	private  Choice color_choices;
	private  Color curr_color=Color.black;
	
	public void init()
	{
		this.setBackground(Color.white);
		clear=new Button("Clear");
		clear.setBackground(Color.lightGray);
		// add background & foreground color to button
		clear.setForeground(Color.black);
		this.add(clear);
		
		color_choices = new Choice();
		color_choices.addItem("black");
		color_choices.addItem("red");
		color_choices.addItem("yellow");
		color_choices.addItem("blue");
		color_choices.addItem("green");
		color_choices.addItem("magenta");
		color_choices.addItem("orange");
		color_choices.addItem("pink");
		color_choices.setForeground(Color.black);
		color_choices.setBackground(Color.lightGray);
		this.add(new Label("Color: "));
		this.add(color_choices);
		
	}
	
	public boolean mouseDown(Event e, int x, int y)
	{
		last_x= x; last_y=y;
		return true;
	}
	
	public boolean mouseDrag(Event e, int x, int y)
	{
		Graphics g = this.getGraphics();
		g.setColor(curr_color);
		g.drawLine(last_x,last_y, x, y);
		last_x=x; 
		last_y=y;
		return true;
	}
	
	public boolean action ( Event e, Object obj )
	{
		if(e.target == clear )
		{
			Graphics g = this.getGraphics();
			Rectangle r = this.bounds();
			g.setColor(this.getBackground());
			g.fillRect(r.x, r.y, r.width, r.height);
			return true;
		}
			
		else if( e.target == color_choices)  {
			if(obj.equals("red"))	       curr_color=Color.red;
			else if(obj.equals("yellow"))  curr_color=Color.yellow;
			else if(obj.equals("blue"))    curr_color=Color.blue;
			else if(obj.equals("green"))   curr_color=Color.green;
			else if(obj.equals("magenta")) curr_color=Color.magenta;
			else if(obj.equals("orange"))  curr_color=Color.orange;
			else if(obj.equals("pink"))   curr_color=Color.pink;
			else curr_color=Color.black;
			return true;
		}
		else return super.action(e,obj);
	}
}

/*
<applet code= "Scribble.class" height="500" width="500">
</applet>1
*/

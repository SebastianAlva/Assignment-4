/**
 * This class represents the plot object with x, y, width, and depth values
 * 
 * @author sebas
 *
 */
public class Plot {
	//The x-value of the upper-left corner of the Plot
	private int x;
	//The y-value of the upper-left corner of the Plot
	private int y;
	//The horizontal extent of the Plot
	private int width;
	//The vertical extent of the Plot
	private int depth;

	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}

	public Plot(Plot p) {
		this.x = p.x;
		this.y = p.x;
		this.width = p.width;
		this.depth = p.depth;

	}

	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getDepth() {
		return depth;
	}

	
	public boolean overlaps(Plot plot) {
		boolean result = false;
		//calcular la parte izquierda arriba y derecha arriba 
		if (plot.getX() <= this.x + this.width && this.x <= plot.getX() + plot.getWidth())
		{
			result = true;
		}
		if (this.y < plot.getY() + plot.getDepth() && this.y + this.depth > plot.getY()) 
		{
			if (plot.getX() <= this.x + this.width)
			{
				if (this.x <= plot.getX() + plot.getWidth()) 
				{
					result = true;
				}
			}
		} else 
		{
			result = false;
		}

		return result;

	}

	public boolean encompasses(Plot plot) {
		boolean plotEncompasses = false;

		if ((plot.getX() + plot.getWidth())<= (this.x+this.width) //left part of the plot rectangle is inside of this.rectangle
			&& plot.getX()>this.x//this.x is greater or equal than plot.X
			&& plot.getY()> this.y //this.y is greater or equal than plot.y
			&&plot.getY() + plot.getDepth() <= this.y + this.depth)//Upper part of the plot rectangle is inside or equal to this.rectangle
		{
			plotEncompasses = true; 
		}
		else {
			plotEncompasses = false; 
		}
			
		return plotEncompasses;
	}

	public String toString() {
		String str = "Upper left: (" + getX() + "," + getY() + "); Width: " + getWidth() + " Depth: " + getDepth();

		return str;
	}

}

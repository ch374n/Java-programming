
class Pixel {
	private String color;
	public Pixel(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
public class BoundaryFill {
	public static void main(String[] args) {
		Pixel[][] pixelArr = new Pixel[30][60];
		String oldColor = "\u001B[33m";
		String newColor = "\u001B[31m";
		for(int i = 0; i < 30; i++) {
			for(int j = 0; j < 60; j++) {
				if((i > 10 && i < 20) && (j > 10 && j < 30)) {
					pixelArr[i][j] = new Pixel("\u001B[33m");
				}
				else {
					pixelArr[i][j] = new Pixel("\u001B[34m");
				}
			}
		}
		for(Pixel[] pixar : pixelArr) {
			for(Pixel p : pixar) {
				System.out.print(p.getColor() + "*");
			}
				System.out.println();
		}
				System.out.println("\n\n\n");
		boundaryFill(pixelArr, oldColor, newColor, 17, 14); 
		for(Pixel[] pixar : pixelArr) {
			for(Pixel p : pixar) {
				System.out.print(p.getColor() + "*");
			}
				System.out.println();
		}
	}
	public static void boundaryFill(Pixel[][] pixelArr, String oldColor, String newColor, int x, int y) {
		if(x < 0 || y < 0 || x >= 60 || y >= 30) {
			return;
		}					
		if(pixelArr[x][y].getColor() != oldColor) {
			return;
		}
		if(pixelArr[x][y].getColor() == oldColor) {
			pixelArr[x][y].setColor(newColor);	
		}
			boundaryFill(pixelArr, oldColor, newColor, x - 1, y);
			boundaryFill(pixelArr, oldColor, newColor, x, y - 1);
			boundaryFill(pixelArr, oldColor, newColor, x + 1, y);
			boundaryFill(pixelArr, oldColor, newColor, x, y + 1);
	}
}
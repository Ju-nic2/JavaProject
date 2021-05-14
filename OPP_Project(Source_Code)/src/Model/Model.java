package Model;

public class Model {
	public int Rectcnt=0;
	private Rectangles[] RectBag = new Rectangles[100];
	
	public Rectangles[] getRectBag(){
		RectBag[Rectcnt] = new Rectangles();
		return RectBag;
	}
}

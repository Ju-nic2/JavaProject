package Control;

public class Storage {
	private String word;
	private int preLevel;
	private int nodeLevel;
	
	public Storage()
	{
		
	}
	public Storage (String word,int preLevel, int nodeLevel) {
		this.word=word;
		this.preLevel=preLevel;
		this.nodeLevel=nodeLevel;
	}
	public String getWord() {
		return this.word;
	}
	public int getPreLevel() {
		return this.preLevel;
	}
	public int getNodeLevel() {
		return this.nodeLevel;
	}
	
	public void setWord(String word) {
		 this.word=word;
	}
	public void setPreLevel(int preLevel) {
		this.preLevel=preLevel;
	}
	public void setNodeLevel(int nodeLevel) {
		this.nodeLevel=nodeLevel;
	}
	public Storage getInfo() {
		return this;
	}

}

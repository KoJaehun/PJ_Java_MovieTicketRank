package domain;

public class MovieDTO {
	private int mno;
	private String title;
	private String content;
	private String writer;
	private int score;
	private String loc;
	private int regdate;
	
	public MovieDTO() { }

	public MovieDTO(int mno, String title, String content, String writer, int score, String loc, int regdate) {
		super();
		this.mno = mno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.score = score;
		this.loc = loc;
		this.regdate = regdate;
	}
	

	public MovieDTO(String title, String content, String writer, int score, String loc, int regdate) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.score = score;
		this.loc = loc;
		this.regdate = regdate;
	}

	public MovieDTO(String content, String writer, int score, int regdate) {
		super();
		this.content = content;
		this.writer = writer;
		this.score = score;
		this.regdate = regdate;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public int getRegdate() {
		return regdate;
	}

	public void setRegdate(int regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "MovieDTO [mno=" + mno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", score="
				+ score + ", loc=" + loc + ", regdate=" + regdate + "]";
	}

	public MovieDTO(int mno, String title, String content, String writer, int score, int regdate) {
		super();
		this.mno = mno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.score = score;
		this.regdate = regdate;
	}
	
	
	
}

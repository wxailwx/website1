package cn.com.p1;

public class Srt {
	public int id;
	public int data;
	public Srt(int m,int n) {
		id=m;
		data=n;
	}
	
	public void exchange(Srt p) {
		int m=id;
		int n=data;
		id=p.id;
		data=p.data;
		p.id=m;
		p.data=n;
	}
	
}

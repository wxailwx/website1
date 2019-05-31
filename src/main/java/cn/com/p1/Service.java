package cn.com.p1;

public class Service {


	public int id;
	public int[] link;
	public int fre;
	
	public Service(int n,Count count) {
		id=n;
		link=new int[100];
		count.Ser++;
	}
	
	public void updatalink(Count count,Linkmo linkmo) {
		Srt[] a=new Srt[count.Ser];
		
		for(int i=0;i<count.Ser;i++) {
			a[i]=new Srt(i,linkmo.linkSer[id][i]);
		}
		
		for(int i=0;i<count.Ser;i++) {
			for(int n=0;n<count.Ser-1;n++) {
				if(a[n].data<a[n+1].data) {
					a[n].exchange(a[n+1]);
				}
			}
		}
		
		for(int i=0;i<count.Ser;i++) {
			link[i]=a[i].id;
		}

	}
		
		
}

package cn.com.p1;

public class Shop {


	public int id;
	public int[] link;
	public int fre;
	
	public Shop(int n,Count count) {
		id=n;
		link=new int[100];
		count.Shop++;
	}
	
	public void updatalink(Count count,Linkmo linkmo) {
		Srt[] a=new Srt[count.Shop];
		
		for(int i=0;i<count.Shop;i++) {
			a[i]=new Srt(i,linkmo.linkShop[id][i]);
		}
		
		for(int i=0;i<count.Shop;i++) {
			for(int n=0;n<count.Shop-1;n++) {
				if(a[n].data<a[n+1].data) {
					a[n].exchange(a[n+1]);
				}
			}
		}
		
		for(int i=0;i<count.Shop;i++) {
			link[i]=a[i].id;
		}

	}
		
		
}

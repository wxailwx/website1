package cn.com.p1;

public class Linkmo {

	public int[][] linkSer;
	public int[][] linkShop;
	
	
	public Linkmo() {
		linkSer= new int[100][100];
		linkShop = new int[100][100];
		
	}
	
	public Linkmo(Linkmo a,Linkmo b,Count count) {
		linkSer= new int[100][100];
		linkShop = new int[100][100];
		for(int i=0;i<count.Ser;i++) {
			for(int j=0;j<count.Ser;i++) {
				linkSer[i][j]=(a.linkSer[i][j]+b.linkSer[i][j])/2;
			}
		}
		
		for(int i=0;i<count.Shop;i++) {
			for(int j=0;j<count.Shop;i++) {
				linkShop[i][j]=(a.linkShop[i][j]+b.linkShop[i][j])/2;
			}
		}
	}
	
	public Linkmo(Users[] a,Count count) {
		linkSer= new int[100][100];
		linkShop = new int[100][100];
		for(int i=0;i<count.Ser;i++) {
			for(int j=0;j<count.Ser;j++) {
				linkSer[i][j]=0;
				for(int k=0;k<count.U;k++) {
					linkSer[i][j]=linkSer[i][j]+a[k].link.linkSer[i][j];
				}
				linkSer[i][j]=linkSer[i][j]/count.U;
			}
		}
		for(int i=0;i<count.Shop;i++) {
			for(int j=0;j<count.Shop;j++) {
				linkShop[i][j]=0;
				for(int k=0;k<count.U;k++) {
					linkShop[i][j]=linkShop[i][j]+a[k].link.linkShop[i][j];
				}
				linkShop[i][j]=linkShop[i][j]/count.U;
			}
		}
	}
	
	void updatalinkSer(Users a) {
		
		for(int m=0;m<a.counthisSer;m++) {
			if(m-3>=0) {
				linkSer[a.historySer[m]][a.historySer[m-3]]+=1;
			}
			if(m-2>=0) {
				linkSer[a.historySer[m]][a.historySer[m-2]]+=2;
			}
			if(m-1>=0) {
				linkSer[a.historySer[m]][a.historySer[m-1]]+=3;
			}
			if(m+1<a.counthisSer) {
				linkSer[a.historySer[m]][a.historySer[m+1]]+=3;
			}
			if(m+2<a.counthisSer) {
				linkSer[a.historySer[m]][a.historySer[m+2]]+=2;
			}
			if(m+3<a.counthisSer) {
				linkSer[a.historySer[m]][a.historySer[m+3]]+=1;
			}
		}
	}
	
	
	void updatalinkShop(Users a) {
		
		for(int m=0;m<a.counthisShop;m++) {
			if(m-3>=0) {
				linkShop[a.historyShop[m]][a.historyShop[m-3]]+=1;
			}
			if(m-2>=0) {
				linkShop[a.historyShop[m]][a.historyShop[m-2]]+=2;
			}
			if(m-1>=0) {
				linkShop[a.historyShop[m]][a.historyShop[m-1]]+=3;
			}
			if(m+1<a.counthisShop) {
				linkShop[a.historyShop[m]][a.historyShop[m+1]]+=3;
			}
			if(m+2<a.counthisShop) {
				linkShop[a.historyShop[m]][a.historyShop[m+2]]+=2;
			}
			if(m+3<a.counthisShop) {
				linkSer[a.historyShop[m]][a.historyShop[m+3]]+=1;
			}
		}
	}
	

	

}

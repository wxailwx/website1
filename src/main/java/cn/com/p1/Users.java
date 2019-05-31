package cn.com.p1;

public class Users {
	public int id;
	public int[] historySer;
	public int counthisSer;
	public int[] historyShop;
	public int counthisShop;
	public Linkmo link;
	
	public Users(Users[] users, Count count) {
		id=-1;
		historySer=new int[100];
		historyShop=new int[100];
		counthisSer=0;
		counthisShop=0;
		link = new Linkmo(users,count);
	}
	
	public Users(int n,Count count) {
		id=n;
		historySer=new int[100];
		historyShop=new int[100];
		counthisSer=0;
		counthisShop=0;
		link = new Linkmo();
		count.U++;
	}
	
    public void updatahisSer(int n) {
    	historySer[counthisSer]=n;
    	counthisSer++;
    }
    
    public void updatahisShop(int n) {
    	historyShop[counthisShop]=n;
    	counthisShop++;
    }
	
    public void ave(Users a,Count count) {
    	link = new Linkmo(link,a.link,count);
    }
	
}

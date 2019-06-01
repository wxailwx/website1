package cn.com.p1;

public class Test {

	public static int[] comSer1(Users a,Service[] s) {
		int[] com=new int[100];
		int i=0,k=0,re=0,m=0;
		for(i=0;i<a.counthisSer;i++) {
			for(m=0,re=0;m<k;m++) {
				if(s[a.historySer[i]].link[0]==com[m]) {
					re=1;
				}
			}
			if(re==1) {
				continue;
			}
			com[k]=s[a.historySer[i]].link[0];
			k++;
		}
		int[] Com=new int[s.length];
		for(i=0;i<k;i++) {
			Com[i]=com[i];
		}

		for(int j= 0;j<s.length;j++) {
			for(i=0,re=0;i<k;i++) {
				if(Com[i]==j) {
					re=1;
				}
			}
			if(re==0) {
				Com[k]=j;
				k++;
			}
		}

		return Com;
	}

	public static int[] comShop1(Users a,Shop[] s) {
		int[] com=new int[100];
		int i=0,k=0,re=0,m=0;
		for(i=0;i<a.counthisShop;i++) {
			for(m=0,re=0;m<k;m++) {
				if(s[a.historyShop[i]].link[0]==com[m]) {
					re=1;
				}
			}
			if(re==1) {
				continue;
			}
			com[k]=s[a.historyShop[i]].link[0];
			k++;
		}
		int[] Com=new int[s.length];
		for(i=0;i<k;i++) {
			Com[i]=com[i];
		}

		for(int j= 0;j<s.length;j++) {
			for(i=0,re=0;i<k;i++) {
				if(Com[i]==j) {
					re=1;
				}
			}
			if(re==0) {
				Com[k]=j;
				k++;
			}
		}

		return Com;
	}
	
	public static int[] comSer2(Service[] s,Count count) {
		Srt[] e=new Srt[count.Ser];
		for(int i=0;i<count.Ser;i++) {
			e[i]=new Srt(i,s[i].fre);
		}
		for(int i=0;i<count.Ser;i++) {
			for(int n=0;n<count.Ser-1;n++) {
				if(e[n].data<e[n+1].data) {
					e[n].exchange(e[n+1]);
				}
			}
		}
		Users a=new Users(-1,count);
		for(int i=0;i<count.Ser;i++) {
			a.historySer[i]=e[i].id;
		}
		a.counthisSer=count.Ser;
		return comSer1(a,s);
	}

	public static int[] comShop2(Shop[] s,Count count) {
		Srt[] e=new Srt[count.Shop];
		for(int i=0;i<count.Shop;i++) {
			e[i]=new Srt(i,s[i].fre);
		}
		for(int i=0;i<count.Shop;i++) {
			for(int n=0;n<count.Shop-1;n++) {
				if(e[n].data<e[n+1].data) {
					e[n].exchange(e[n+1]);
				}
			}
		}
		Users a=new Users(-1,count);
		for(int i=0;i<count.Ser;i++) {
			a.historySer[i]=e[i].id;
		}
		for(int i=0;i<count.Shop;i++) {
			a.historyShop[i]=e[i].id;
		}
		a.counthisShop=count.Shop;
		return comShop1(a,s);
	}
	
	public static void addhisSer(Users a,Service[] list,int m) {
		a.updatahisSer(m);
		list[m].fre++;
	
	}
	public static void addhisShop(Users a,Shop[] list,int m) {
		a.updatahisShop(m);
		list[m].fre++;
	
	}
	public static int[] serstart1(int countU,int countSer,int id,int[][] history) {
		Count count = new Count(0,0,0);
		Users[] testuser= new Users[countU];
		Service[] testser=new Service[countSer];
		for(int i=0;i<countSer;i++) {
			testser[i]=new Service(i,count);
		}
		for(int i=0;i<countU;i++) {
			testuser[i]=new Users(i,count);
		}
		for(int i=0;i<countU;i++) {
			for(int j=0;j<history[i].length;j++) {
				addhisSer(testuser[i],testser,history[i][j]);
			}
		}
		for(int i=0;i<countU;i++) {
			testuser[i].link.updatalinkSer(testuser[i]);
		}
		Users usu=new Users(testuser,count);
		for(int i=0;i<countSer;i++) {
			testser[i].updatalink(count,usu.link);
		}
		return comSer1(testuser[id-1],testser);
	}
	
	public static int[] shopstart1(int countU,int countShop,int id,int[][] history) {
		Count count = new Count(0,0,0);
		Users[] testuser= new Users[countU];
		Shop[] testshop=new Shop[countShop];
		for(int i=0;i<countShop;i++) {
			testshop[i]=new Shop(i,count);
		}
		for(int i=0;i<countU;i++) {
			testuser[i]=new Users(i,count);
		}
		for(int i=0;i<countU;i++) {
			for(int j=0;j<history[i].length;j++) {
				addhisShop(testuser[i],testshop,history[i][j]);
			}
		}
		for(int i=0;i<countU;i++) {
			testuser[i].link.updatalinkShop(testuser[i]);
		}
		Users usu=new Users(testuser,count);
		for(int i=0;i<countShop;i++) {
			testshop[i].updatalink(count,usu.link);
		}
		return comShop1(testuser[id-1],testshop);
	}
	
	public static int[] serstart2(int countU,int countSer,int[][] history) {
		Count count = new Count(0,0,0);
		Users[] testuser= new Users[countU];
		Service[] testser=new Service[countSer];
		for(int i=0;i<countSer;i++) {
			testser[i]=new Service(i,count);
		}
		for(int i=0;i<countU;i++) {
			testuser[i]=new Users(i,count);
		}
		for(int i=0;i<countU;i++) {
			for(int j=0;j<history[i].length;j++) {
				addhisSer(testuser[i],testser,history[i][j]);
			}
		}
		for(int i=0;i<countU;i++) {
			testuser[i].link.updatalinkSer(testuser[i]);
		}
		Users usu=new Users(testuser,count);
		for(int i=0;i<countSer;i++) {
			testser[i].updatalink(count,usu.link);
		}
		return comSer2(testser,count);
	}
	
	public static int[] shopstart2(int countU,int countShop,int[][] history) {
		Count count = new Count(0,0,0);
		Users[] testuser= new Users[countU];
		Shop[] testshop=new Shop[countShop];
		for(int i=0;i<countShop;i++) {
			testshop[i]=new Shop(i,count);
		}
		for(int i=0;i<countU;i++) {
			testuser[i]=new Users(i,count);
		}
		for(int i=0;i<countU;i++) {
			for(int j=0;j<history[i].length;j++) {
				addhisShop(testuser[i],testshop,history[i][j]);
			}
		}
		for(int i=0;i<countU;i++) {
			testuser[i].link.updatalinkShop(testuser[i]);
		}
		Users usu=new Users(testuser,count);
		for(int i=0;i<countShop;i++) {
			testshop[i].updatalink(count,usu.link);
		}
		return comShop2(testshop,count);
	}
	
	public static int[] toint(String a) {
		String[] p=a.split(",");
		int l = p.length;
		int[] res=new int[l];
		for(int i=0;i<l;i++) {
			res[i]=Integer.parseInt( p[i] );
		}
		return res;
	}
	
 	
}

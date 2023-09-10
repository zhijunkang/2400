package come.tool.Mixdeal;


/**
 * 基础值
 * @author Administrator
 *
 */
public class PetGrade {
	//测试
	public static void main(String[] args) {
		int lvl = 145;//等级
		int base = 145;//初值
		double G = 2.5;//成长
		System.out.println("血"+getRoleValue(lvl, lvl * 8, G, base,1));
		System.out.println("攻"+getRoleValue(lvl, lvl * 8, G, base,2));
		System.out.println("敏"+getRoleValue(lvl, lvl * 8, G, base,3));
	}
	//(base*(1+lvl*0.02))+lvl
    //HP=int(级别*成长*点数)+int((0.7*级别*成长+1)*初值) 
    //MP=int(级别*成长*点数)+int((0.7*级别*成长+1)*初值)
    //AP=int(级别*成长*点数/5)+int((0.14*级别*成长+1)*初值)
    //SP=int(初敏+点数）*成长  
    //获取召唤兽的属性值                               等级   点数 成长 基础值 0hp 1mp 2ap 3sp 
	public static int getRoleValue(int lvl,int P,double G,int base,int type){
		//int E=(100-lvl)/5;
		//int LEPG=(int) ((lvl+E)*P*G);
		if (type==0||type==1) {
			return (int) (lvl*P*G)+(int)((0.7*lvl*G+1)*base);
		}else if (type==2) {
			return (int) (lvl*P*G/5)+(int)((0.14*lvl*G+1)*base);
		}else {
			return (int) ((base+P/2)*G);
		}	
	}
}

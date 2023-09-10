package org.come.bean;

public class Ql {
	//抗物理
		private double rolekwl=0;

		//抗震慑
		private double rolekzs=0;

		//抗风
		private double rolekff=0;

		//抗雷
		private double roleklf=0;

		//坑水
		private double roleksf=0;

		//坑火
		private double rolekhf=0;

		//抗混乱
		private double rolekhl=0;

		//抗昏睡
		private double rolekhs=0;

		//抗封印
		private double rolekfy=0;

		//抗中毒
		private double rolekzd=0;

		//抗遗忘
		private double rolekyw=0;

		//抗鬼火
		private double rolekgh=0;

		//抗三尸
		private double roleksc=0;

		//忽视防御程度
		private double rolehsfyv=0;

		//忽视防御几率
		private double rolehsfyl=0;

		//忽视风法
		private double rolehsff=0;

		//忽视雷法
		private double rolehslf=0;

		//忽视水法
		private double rolehssf=0;

		//忽视火法
		private double rolehshf=0;

		//忽视混乱
		private double rolehshl=0;

		//忽视昏睡
		private double rolehshs=0;

		//忽视封印
		private double rolehsfy=0;

		//忽视中毒
		private double rolehszd=0;

		//强风法
		private double roleqff=0;

		//强雷法
		private double roleqlf=0;

		//强水法
		private double roleqsf=0;

		//强火法
		private double roleqhf=0;

		//强混乱
		private double roleqhl=0;

		//强昏睡
		private double roleqhs=0;
		//强震慑
		private double roleqzs=0;
		//强封印
		private double roleqfy=0;

		//强中毒
		private double roleqzd=0;

		//躲闪率
		private double rolefdsl=0;

		//反击率
		private double roleffjl=0;

		//反击次数
		private double roleffjv=0;

		//连击率
		private double rolefljl=0;

		//连击次数
		private double rolefljv=0;

		//命中率
		private double rolefmzl=0;
		//致命率
		private double rolefzml=0;
		//狂暴率
		private double rolefkbl=0;

		//反震率
		private double roleffzl=0;

		//反震程度
		private double roleffzcd=0;

		//中毒率
		private double rolefzdl=0;

		//金
		private double rolewxj=0;

		//木
		private double rolewxm=0;

		//土
		private double rolewxt=0;

		//水
		private double rolewxs=0;

		//火
		private double rolewxh=0;

		//强力克金
		private double rolewxqkj=0;

		//强力克木
		private double rolewxqkm=0;

		//强力克土
		private double rolewxqkt=0;

		//强力克水
		private double rolewxqks=0;

		//强力克火
		private double rolewxqkh=0;

		//无属性伤害
		private double rolewsxsh=0;

		//风法伤害
		private double roleffsh=0;

		//雷法伤害
		private double rolelfsh=0;

		//水法伤害
		private double rolesfsh=0;

		//火法伤害
		private double rolehfsh=0;

		//雷法狂暴
		private double rolelfkb=0;

		//风法狂暴
		private double roleffkb=0;

		//水法狂暴
		private double rolesfkb=0;

		//火法狂暴
		private double rolehfkb=0;

		//毒伤害
		private double rolezdsh=0;

		//鬼火伤害
		private double roleghsh=0;

		//三尸伤害
		private double rolesssh=0;

	    //强鬼火
		private double rolegstronghostfire=0;

		//强遗忘
		private double rolestrongforget=0;

		//强三尸血
		private double rolestrongbodyblood=0;

		//强三尸血回血程度
		private double rolestrongbodyblooddeep=0;

		  //鬼火狂暴
	    private double roleghkb=0;

	    //三尸虫狂暴
	    private double rolesskb=0;

	  //忽视躲闪
	    private double rolehsds=0;
	  //忽视反击
	    private double rolehsfj=0;
	  //仙法连击率
	    private double rolexfljl=0;
	  //仙法连击次数
	    private double rolexfljs=0;
	  //忽视仙法抗性率
	    private double rolehsxfkl=0;
	  //忽视仙法抗性程度
	    private double rolehsxfcd=0;
		//忽视鬼火
		private double rolehsgh=0;
		//加强攻击法术效果
		private double jqgjfs=0;
		//加强防御法术效果
		private double jqfyfs=0;
		//加强速度法术效果
		private double jqsdfs=0;


		//忽视遗忘
		private double rolehsyw=0;
		public void Reset(){
			this.rolekwl=0;this.rolekzs=0;this.rolekff=0;this.roleklf=0;this.roleksf=0;this.rolekhf=0;
            this.rolekhl=0;this.rolekhs=0;this.rolekfy=0;this.rolekzd=0;this.rolekyw=0;this.rolekgh=0;
            this.roleksc=0;this.rolehsfyv=0;this.rolehsfyl=0;this.rolehsff=0;this.rolehslf=0;
            this.rolehssf=0;this.rolehshf=0;this.rolehshl=0;this.rolehshs=0;this.rolehsfy=0;
            this.rolehszd=0;this.roleqff=0;this.roleqlf=0;this.roleqsf=0;this.roleqhf=0;
            this.roleqhl=0;this.roleqhs=0;this.roleqzs=0;this.roleqfy=0;this.roleqzd=0;
            this.rolefdsl=0;this.roleffjl=0;this.roleffjv=0;this.rolefljl=0;this.rolefljv=0;
            this.rolefmzl=0;this.rolefkbl=0;this.roleffzl=0;this.roleffzcd=0;this.rolefzdl=0;
            this.rolewxj=0;this.rolewxm=0;this.rolewxt=0;this.rolewxs=0;this.rolewxh=0;
            this.rolewxqkj=0;this.rolewxqkm=0;this.rolewxqkt=0;this.rolewxqks=0;
            this.rolewxqkh=0;this.rolewsxsh=0;this.roleffsh=0;this.rolelfsh=0;this.rolesfsh=0;
            this.rolehfsh=0;this.rolelfkb=0;this.roleffkb=0;this.rolesfkb=0;this.rolehfkb=0;
			this.rolezdsh=0;this.roleghsh=0;this.rolesssh=0;this.rolegstronghostfire=0;
			this.rolestrongforget=0;this.rolestrongbodyblood=0;this.rolestrongbodyblooddeep=0;
			this.roleghkb=0;this.rolesskb=0;this.rolehsds=0;this.rolehsfj=0;this.rolexfljl=0;this.rolexfljs=0;
			this.rolehsxfkl=0;this.rolehsxfcd=0;this.rolehsgh=0;this.rolehsyw=0;this.rolefzml=0;
			this.jqgjfs=0;this.jqfyfs=0;this.jqsdfs=0;
		}

		public double getRolekwl() {
			return this.rolekwl;
		}

		public void setRolekwl(double rolekwl) {
			this.rolekwl = rolekwl;
		}

		public double getRolekzs() {
			return this.rolekzs;
		}

		public void setRolekzs(double rolekzs) {
			this.rolekzs = rolekzs;
		}

		public double getRolekff() {
			return this.rolekff;
		}

		public void setRolekff(double rolekff) {
			this.rolekff = rolekff;
		}

		public double getRoleklf() {
			return this.roleklf;
		}

		public void setRoleklf(double roleklf) {
			this.roleklf = roleklf;
		}

		public double getRoleksf() {
			return this.roleksf;
		}

		public void setRoleksf(double roleksf) {
			this.roleksf = roleksf;
		}

		public double getRolekhf() {
			return this.rolekhf;
		}

		public void setRolekhf(double rolekhf) {
			this.rolekhf = rolekhf;
		}

		public double getRolekhl() {
			return this.rolekhl;
		}

		public void setRolekhl(double rolekhl) {
			this.rolekhl = rolekhl;
		}

		public double getRolekhs() {
			return this.rolekhs;
		}

		public void setRolekhs(double rolekhs) {
			this.rolekhs = rolekhs;
		}

		public double getRolekfy() {
			return this.rolekfy;
		}

		public void setRolekfy(double rolekfy) {
			this.rolekfy = rolekfy;
		}

		public double getRolekzd() {
			return this.rolekzd;
		}

		public void setRolekzd(double rolekzd) {
			this.rolekzd = rolekzd;
		}

		public double getRolekyw() {
			return this.rolekyw;
		}

		public void setRolekyw(double rolekyw) {
			this.rolekyw = rolekyw;
		}

		public double getRolekgh() {
			return this.rolekgh;
		}

		public void setRolekgh(double rolekgh) {
			this.rolekgh = rolekgh;
		}

		public double getRoleksc() {
			return this.roleksc;
		}

		public void setRoleksc(double roleksc) {
			this.roleksc = roleksc;
		}

		public double getRolehsfyv() {
			return this.rolehsfyv;
		}

		public void setRolehsfyv(double rolehsfyv) {
			this.rolehsfyv = rolehsfyv;
		}

		public double getRolehsfyl() {
			return this.rolehsfyl;
		}

		public void setRolehsfyl(double rolehsfyl) {
			this.rolehsfyl = rolehsfyl;
		}

		public double getRolehsff() {
			return this.rolehsff;
		}

		public void setRolehsff(double rolehsff) {
			this.rolehsff = rolehsff;
		}

		public double getRolehslf() {
			return this.rolehslf;
		}

		public void setRolehslf(double rolehslf) {
			this.rolehslf = rolehslf;
		}

		public double getRolehssf() {
			return this.rolehssf;
		}

		public void setRolehssf(double rolehssf) {
			this.rolehssf = rolehssf;
		}

		public double getRolehshf() {
			return this.rolehshf;
		}

		public void setRolehshf(double rolehshf) {
			this.rolehshf = rolehshf;
		}

		public double getRolehshl() {
			return this.rolehshl;
		}

		public void setRolehshl(double rolehshl) {
			this.rolehshl = rolehshl;
		}

		public double getRolehshs() {
			return this.rolehshs;
		}

		public void setRolehshs(double rolehshs) {
			this.rolehshs = rolehshs;
		}

		public double getRolehsfy() {
			return this.rolehsfy;
		}

		public void setRolehsfy(double rolehsfy) {
			this.rolehsfy = rolehsfy;
		}

		public double getRolehszd() {
			return this.rolehszd;
		}

		public void setRolehszd(double rolehszd) {
			this.rolehszd = rolehszd;
		}

		public double getRoleqff() {
			return this.roleqff;
		}

		public void setRoleqff(double roleqff) {
			this.roleqff = roleqff;
		}

		public double getRoleqlf() {
			return this.roleqlf;
		}

		public void setRoleqlf(double roleqlf) {
			this.roleqlf = roleqlf;
		}

		public double getRoleqsf() {
			return this.roleqsf;
		}

		public void setRoleqsf(double roleqsf) {
			this.roleqsf = roleqsf;
		}

		public double getRoleqhf() {
			return this.roleqhf;
		}

		public void setRoleqhf(double roleqhf) {
			this.roleqhf = roleqhf;
		}

		public double getRoleqhl() {
			return this.roleqhl;
		}

		public void setRoleqhl(double roleqhl) {
			this.roleqhl = roleqhl;
		}

		public double getRoleqhs() {
			return this.roleqhs;
		}

		public void setRoleqhs(double roleqhs) {
			this.roleqhs = roleqhs;
		}

		public double getRoleqzs() {
			return this.roleqzs;
		}

		public void setRoleqzs(double roleqzs) {
			this.roleqzs = roleqzs;
		}

		public double getRoleqfy() {
			return this.roleqfy;
		}

		public void setRoleqfy(double roleqfy) {
			this.roleqfy = roleqfy;
		}

		public double getRoleqzd() {
			return this.roleqzd;
		}

		public void setRoleqzd(double roleqzd) {
			this.roleqzd = roleqzd;
		}

		public double getRolefdsl() {
			return this.rolefdsl;
		}

		public void setRolefdsl(double rolefdsl) {
			this.rolefdsl = rolefdsl;
		}

		public double getRoleffjl() {
			return this.roleffjl;
		}

		public void setRoleffjl(double roleffjl) {
			this.roleffjl = roleffjl;
		}

		public double getRoleffjv() {
			return this.roleffjv;
		}

		public void setRoleffjv(double roleffjv) {
			this.roleffjv = roleffjv;
		}

		public double getRolefljl() {
			return this.rolefljl;
		}

		public void setRolefljl(double rolefljl) {
			this.rolefljl = rolefljl;
		}

		public double getRolefljv() {
			return this.rolefljv;
		}

		public void setRolefljv(double rolefljv) {
			this.rolefljv = rolefljv;
		}

		public double getRolefmzl() {
			return this.rolefmzl;
		}

		public void setRolefmzl(double rolefmzl) {
			this.rolefmzl = rolefmzl;
		}

		public double getRolefkbl() {
			return this.rolefkbl;
		}

		public void setRolefkbl(double rolefkbl) {
			this.rolefkbl = rolefkbl;
		}

		public double getRoleffzl() {
			return this.roleffzl;
		}

		public void setRoleffzl(double roleffzl) {
			this.roleffzl = roleffzl;
		}

		public double getRoleffzcd() {
			return this.roleffzcd;
		}

		public void setRoleffzcd(double roleffzcd) {
			this.roleffzcd = roleffzcd;
		}

		public double getRolefzdl() {
			return this.rolefzdl;
		}

		public void setRolefzdl(double rolefzdl) {
			this.rolefzdl = rolefzdl;
		}

		public double getRolewxj() {
			return this.rolewxj;
		}

		public void setRolewxj(double rolewxj) {
			this.rolewxj = rolewxj;
		}

		public double getRolewxm() {
			return this.rolewxm;
		}

		public void setRolewxm(double rolewxm) {
			this.rolewxm = rolewxm;
		}

		public double getRolewxt() {
			return this.rolewxt;
		}

		public void setRolewxt(double rolewxt) {
			this.rolewxt = rolewxt;
		}

		public double getRolewxs() {
			return this.rolewxs;
		}

		public void setRolewxs(double rolewxs) {
			this.rolewxs = rolewxs;
		}

		public double getRolewxh() {
			return this.rolewxh;
		}

		public void setRolewxh(double rolewxh) {
			this.rolewxh = rolewxh;
		}

		public double getRolewxqkj() {
			return this.rolewxqkj;
		}

		public void setRolewxqkj(double rolewxqkj) {
			this.rolewxqkj = rolewxqkj;
		}

		public double getRolewxqkm() {
			return this.rolewxqkm;
		}

		public void setRolewxqkm(double rolewxqkm) {
			this.rolewxqkm = rolewxqkm;
		}

		public double getRolewxqkt() {
			return this.rolewxqkt;
		}

		public void setRolewxqkt(double rolewxqkt) {
			this.rolewxqkt = rolewxqkt;
		}

		public double getRolewxqks() {
			return this.rolewxqks;
		}

		public void setRolewxqks(double rolewxqks) {
			this.rolewxqks = rolewxqks;
		}

		public double getRolewxqkh() {
			return this.rolewxqkh;
		}

		public void setRolewxqkh(double rolewxqkh) {
			this.rolewxqkh = rolewxqkh;
		}

		public double getRolewsxsh() {
			return this.rolewsxsh;
		}

		public void setRolewsxsh(double rolewsxsh) {
			this.rolewsxsh = rolewsxsh;
		}

		public double getRoleffsh() {
			return this.roleffsh;
		}

		public void setRoleffsh(double roleffsh) {
			this.roleffsh = roleffsh;
		}

		public double getRolelfsh() {
			return this.rolelfsh;
		}

		public void setRolelfsh(double rolelfsh) {
			this.rolelfsh = rolelfsh;
		}

		public double getRolesfsh() {
			return this.rolesfsh;
		}

		public void setRolesfsh(double rolesfsh) {
			this.rolesfsh = rolesfsh;
		}

		public double getRolehfsh() {
			return this.rolehfsh;
		}

		public void setRolehfsh(double rolehfsh) {
			this.rolehfsh = rolehfsh;
		}

		public double getRolelfkb() {
			return this.rolelfkb;
		}

		public void setRolelfkb(double rolelfkb) {
			this.rolelfkb = rolelfkb;
		}

		public double getRoleffkb() {
			return this.roleffkb;
		}

		public void setRoleffkb(double roleffkb) {
			this.roleffkb = roleffkb;
		}

		public double getRolesfkb() {
			return this.rolesfkb;
		}

		public void setRolesfkb(double rolesfkb) {
			this.rolesfkb = rolesfkb;
		}

		public double getRolehfkb() {
			return this.rolehfkb;
		}

		public void setRolehfkb(double rolehfkb) {
			this.rolehfkb = rolehfkb;
		}

		public double getRolezdsh() {
			return this.rolezdsh;
		}

		public void setRolezdsh(double rolezdsh) {
			this.rolezdsh = rolezdsh;
		}

		public double getRoleghsh() {
			return this.roleghsh;
		}

		public void setRoleghsh(double roleghsh) {
			this.roleghsh = roleghsh;
		}

		public double getRolesssh() {
			return this.rolesssh;
		}

		public void setRolesssh(double rolesssh) {
			this.rolesssh = rolesssh;
		}

		public double getRolegstronghostfire() {
			return this.rolegstronghostfire;
		}

		public void setRolegstronghostfire(double rolegstronghostfire) {
			this.rolegstronghostfire = rolegstronghostfire;
		}

		public double getRolestrongforget() {
			return this.rolestrongforget;
		}

		public void setRolestrongforget(double rolestrongforget) {
			this.rolestrongforget = rolestrongforget;
		}

		public double getRolestrongbodyblood() {
			return this.rolestrongbodyblood;
		}

		public void setRolestrongbodyblood(double rolestrongbodyblood) {
			this.rolestrongbodyblood = rolestrongbodyblood;
		}

		public double getRolestrongbodyblooddeep() {
			return this.rolestrongbodyblooddeep;
		}

		public void setRolestrongbodyblooddeep(double rolestrongbodyblooddeep) {
			this.rolestrongbodyblooddeep = rolestrongbodyblooddeep;
		}

		public double getRoleghkb() {
			return this.roleghkb;
		}

		public void setRoleghkb(double roleghkb) {
			this.roleghkb = roleghkb;
		}

		public double getRolesskb() {
			return this.rolesskb;
		}

		public void setRolesskb(double rolesskb) {
			this.rolesskb = rolesskb;
		}

		public double getRolehsds() {
			return this.rolehsds;
		}

		public void setRolehsds(double rolehsds) {
			this.rolehsds = rolehsds;
		}

		public double getRolehsfj() {
			return this.rolehsfj;
		}

		public void setRolehsfj(double rolehsfj) {
			this.rolehsfj = rolehsfj;
		}

		public double getRolexfljl() {
			return this.rolexfljl;
		}

		public void setRolexfljl(double rolexfljl) {
			this.rolexfljl = rolexfljl;
		}

		public double getRolexfljs() {
			return this.rolexfljs;
		}

		public void setRolexfljs(double rolexfljs) {
			this.rolexfljs = rolexfljs;
		}

		public double getRolehsxfkl() {
			return this.rolehsxfkl;
		}

		public void setRolehsxfkl(double rolehsxfkl) {
			this.rolehsxfkl = rolehsxfkl;
		}

		public double getRolehsxfcd() {
			return this.rolehsxfcd;
		}

		public void setRolehsxfcd(double rolehsxfcd) {
			this.rolehsxfcd = rolehsxfcd;
		}

		public double getRolehsgh() {
			return this.rolehsgh;
		}

		public void setRolehsgh(double rolehsgh) {
			this.rolehsgh = rolehsgh;
		}

		public double getRolehsyw() {
			return this.rolehsyw;
		}

		public void setRolehsyw(double rolehsyw) {
			this.rolehsyw = rolehsyw;
		}

		public double getRolefzml() {
			return this.rolefzml;
		}

		public void setRolefzml(double rolefzml) {
			this.rolefzml = rolefzml;
		}

		public double getJqgjfs() {
			return this.jqgjfs;
		}

		public void setJqgjfs(double jqgjfs) {
			this.jqgjfs = jqgjfs;
		}

		public double getJqfyfs() {
			return this.jqfyfs;
		}

		public void setJqfyfs(double jqfyfs) {
			this.jqfyfs = jqfyfs;
		}

		public double getJqsdfs() {
			return this.jqsdfs;
		}

		public void setJqsdfs(double jqsdfs) {
			this.jqsdfs = jqsdfs;
		}

}

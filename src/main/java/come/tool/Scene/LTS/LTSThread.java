package come.tool.Scene.LTS;

import come.tool.PK.PkMatch;

public class LTSThread implements Runnable{

	private LTSScene ltsScene;

	public LTSThread(LTSScene ltsScene) {
		super();
		this.ltsScene = ltsScene;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 360; i++) {
			this.ltsScene.OVERTIME(System.currentTimeMillis());
			try {
				Thread.sleep(20000);//每隔20秒判断是否清空挑战书
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		//调整赛结束
		this.ltsScene.OVERTIME(System.currentTimeMillis()+PkMatch.OTHERTIME*2);
		this.ltsScene.setI(2);	
	}

}

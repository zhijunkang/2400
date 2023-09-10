package come.tool.Scene.BTY;

public class BTYThread implements Runnable{

	private BTYScene btyScene;
	
	public BTYThread(BTYScene btyScene) {
		super();
		this.btyScene = btyScene;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (this.btyScene.isEnd()) {
			if (this.btyScene.time%180==0) {//刷怪
				this.btyScene.open();
			}
			try {
				this.btyScene.move();//移动
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			this.btyScene.time++;
		}
	}

}

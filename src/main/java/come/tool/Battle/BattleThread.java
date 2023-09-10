package come.tool.Battle;

import java.util.ArrayList;
import java.util.List;

import org.come.handler.MainServerHandler;
import org.come.tool.WriteOut;

public class BattleThread implements Runnable{
    /**战斗预知超时*/
	public static final int OVERTIME_PREVIE=5000;
	/**战斗决策超时*/
	public static final int OVERTIME_POLICY=63000;
	/**单条指令最短播放时*/
	public static final int OVERTIME_PLAY_MIN=400;
	/**播放结束同步超时*/
	public static final int OVERTIME_PLAY_END=3000;
	private List<Integer> Numbers;
	public BattleThread(int id) {
		// TODO Auto-generated constructor stub
		this.Numbers=new ArrayList<>();
		this.Numbers.add(id);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long start=System.currentTimeMillis();
		long end  =start;
		while (true) {
			start=System.currentTimeMillis();
			for (int i=this.Numbers.size()-1;i>=0;i--) {
				int id=-1;
				try {
					id=this.Numbers.get(i);
					BattleData battleData=BattleThreadPool.BattleDatas.get(id);
					if (battleData==null){this.Numbers.remove(i);continue;} 
					if (BattleStateType.getBattleStateById(battleData.getBattleState()).handle(battleData)){
						BattleThreadPool.removeBattleData(battleData);
						this.Numbers.remove(i);
					}	
				} catch (Exception e) {
					// TODO: handle exception
					try {
						WriteOut.addtxt("战斗报错:"+MainServerHandler.getErrorMessage(e), 9999);
						BattleData battleData=BattleThreadPool.BattleDatas.get(id);
						if (battleData!=null) {
							battleData.setWinCamp(-2);
							BattleThreadPool.removeBattleData(battleData);
						}	
					} catch (Exception e2) {
						// TODO: handle exception
					}
					this.Numbers.remove(i);
					e.printStackTrace();
				}
			}
			end=System.currentTimeMillis();
			long Pass=600-(end-start);
			try {
				if (Pass>0){
					Thread.sleep(Pass);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (this.Numbers.size()==0){
				if (BattleThreadPool.removeBattleThread(this)) {
					break;	
				}
			}
		}
	}
	public List<Integer> getNumbers() {
		return this.Numbers;
	}
	public void setNumbers(List<Integer> numbers) {
		this.Numbers = numbers;
	}
	
}

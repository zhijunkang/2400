package come.tool.FightingDataAction;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class Petdll {
    public interface Mypetdll extends Library{
        Mypetdll mypetdll=(Mypetdll) Native.load("Mydll",Mypetdll.class);

          String bianshen(int a,int b);


    }
}

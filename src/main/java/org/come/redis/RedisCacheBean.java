package org.come.redis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.come.entity.Goodstable;
import org.come.entity.Lingbao;

public class RedisCacheBean<T> {
	private int I;
	private ConcurrentHashMap<String,RedisObject<T>> Map;
	
	public RedisCacheBean(int i) {
		super();
		this.I = i;
		this.Map = new ConcurrentHashMap<>();
	}
	public void getCaches(Set<String> list,List<T> ts){
		Iterator<String> it = list.iterator();
		for(int i=list.size()-1;i>=0;i--){
		    RedisObject<T> object=this.Map.get(it.next());
			if (object!=null) {ts.add(object.getT());object.setIs(Boolean.TRUE);it.remove();} 	
		}
	}
	public T getCache(String key){
		RedisObject<T> object=this.Map.get(key);
		if (object!=null) {
			object.setIs(Boolean.TRUE);
			return object.getT();
		}
		return null;
	}
	public void addCache(String key,T t){
		RedisObject<T> object=this.Map.get(key);
		if (object!=null) {
			object.setIs(Boolean.TRUE);
			object.setT(t);
			return;
		}
		if (this.I==1) {
			if (t instanceof Goodstable) {
				Goodstable goodstable=(Goodstable) t;
				if (goodstable.getStatus()!=1) {return;}
			}	
		}else if (this.I==3) {
			if (t instanceof Lingbao) {
				Lingbao lingbao=(Lingbao) t;
				if (lingbao.getEquipment()!=1) {return;}
			}
		}	
		object=new RedisObject<T>(t);
		this.Map.put(key,object);
	}
	public void delCache(String key){
		this.Map.remove(key);
	}
	/**重置*/
	public void reset(StringBuffer buffer){
		buffer.append("前");buffer.append(this.Map.size());
		Iterator<String> it = this.Map.keySet().iterator();
		while(it.hasNext()) {
		   String key=it.next();
		   RedisObject<T> value=this.Map.get(key);
		   if (value.getIs()){
			   value.setIs(Boolean.FALSE);
		   }else {
			   it.remove();
		   }
	    }
		buffer.append("后");buffer.append(this.Map.size());
	}
}

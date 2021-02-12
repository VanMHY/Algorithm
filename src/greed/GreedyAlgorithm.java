package greed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreedyAlgorithm {

	public static void main(String[] args) {
		//创建一个广播电台，放入到map中
		HashMap<String,HashSet<String>> broadcasts = new HashMap<String,HashSet<String>>();
		//将格格电台放入到broadcasts中
		HashSet<String> hashSet1 = new HashSet<String>();
		hashSet1.add("北京");
		hashSet1.add("上海");
		hashSet1.add("天津");
		
		HashSet<String> hashSet2 = new HashSet<String>();
		hashSet2.add("广州");
		hashSet2.add("北京");
		hashSet2.add("深圳");
		
		HashSet<String> hashSet3 = new HashSet<String>();
		hashSet3.add("成都");
		hashSet3.add("上海");
		hashSet3.add("杭州");
		
		HashSet<String> hashSet4 = new HashSet<String>();
		hashSet4.add("上海");
		hashSet4.add("天津");
		
		HashSet<String> hashSet5 = new HashSet<String>();
		hashSet5.add("杭州");
		hashSet5.add("大连");
		//加入到map
		broadcasts.put("K1", hashSet1);
		broadcasts.put("K2", hashSet2);
		broadcasts.put("K3", hashSet3);
		broadcasts.put("K4", hashSet4);
		broadcasts.put("K5", hashSet5);
		//allAreas存放所有地区
		HashSet<String> allAreas = new HashSet<String>();
		allAreas.add("北京");
		allAreas.add("上海");
		allAreas.add("天津");
		allAreas.add("广州");
		allAreas.add("深圳");
		allAreas.add("成都");
		allAreas.add("杭州");
		allAreas.add("大连");
		//创建一个ArrayList，存放选择的电台集合
		ArrayList<String> selects = new ArrayList<String>();
		//定义一个临时的集合，在遍历过程中，存放遍历过程中的电台覆盖地区和当前还没有覆盖的地区的交集
		HashSet<String> tempSet = new HashSet<String>();
		//定义一个maxKey,保存在一次遍历过程中，能够覆盖最大未覆盖的地区对应的电台Key；如果maxKey不为null，则加入到selects
		String maxKey= null;
		while(allAreas.size() != 0) {//如果allAreas不为0，则表示还没有覆盖到所有地区
			//*每进行一次while，都要把maxKey致空
			maxKey = null;
			//遍历broadcasts，取出对应的key
			for(String key : broadcasts.keySet()) {
				//*每进行一次for，都要把tempSet清空
				tempSet.clear();
				//当前key能覆盖的地区
				HashSet<String> areas = broadcasts.get(key);
				tempSet.addAll(areas);
				//求出tempSet和allAreas集合的交集；交集会赋给tempSet
				tempSet.retainAll(allAreas);
				//如果当前这个集合包含的未覆盖地区的数量，比maxKey指向的集合的地区还多；就需要重置maxKey
				//tempSet.size() > broadcasts.get(maxKey).size()),这里体现了贪心算法的特点，每次都选择最优的
				if(tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())) {
					maxKey = key;
				}
			}
			//maxKey != null,就应该将maxKey加入selects
			if(maxKey != null) {
				selects.add(maxKey);
				//将maxKey指向的广播覆盖的地区，从allAreas去掉
				allAreas.removeAll(broadcasts.get(maxKey));
			}
		}
		System.out.println("得到的选择结果是" + selects);//[K1,K2,K3,K5]
	}

}

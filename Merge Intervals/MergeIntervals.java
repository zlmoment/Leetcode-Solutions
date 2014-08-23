/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0) {
			return intervals;
		}
		// sort by start value
		int[] startList = new int[intervals.size()];
		for (int i = 0; i < intervals.size(); i++) {
			startList[i] = intervals.get(i).start;
		}
		Arrays.sort(startList);
		HashMap<Integer, int[]> tempInterMap = new HashMap<Integer, int[]>();
		for (Interval inte : intervals) {
			if (!tempInterMap.containsKey(inte.start)) {
				int[] temp = new int[] { inte.end };
				tempInterMap.put(inte.start, temp);
			} else {
				int[] temp = tempInterMap.get(inte.start);
				int[] temp2 = new int[temp.length + 1];
				for (int i = 0; i < temp.length; i++) {
					temp2[i] = temp[i];
				}
				temp2[temp.length] = inte.end;
				Arrays.sort(temp2);
				tempInterMap.put(inte.start, temp2);
			}
		}
		ArrayList<Interval> sortedArray = new ArrayList<Interval>();
		for (int i = 0; i < startList.length;) {
			int[] temp = tempInterMap.get(startList[i]);
			for (int j : temp) {
				sortedArray.add(new Interval(startList[i], j));
				i++;
			}
		}
		ArrayList<Interval> rtnArray = new ArrayList<Interval>();
		// the following process still needs to be understood better
		Interval indexInter = sortedArray.get(0);
		for (int i = 1; i < sortedArray.size(); i++) {
			Interval currInter = sortedArray.get(i);
			if (currInter.start > indexInter.end || indexInter.start > currInter.end) {
				rtnArray.add(indexInter);
				indexInter = currInter;
			} else {
				indexInter.start = indexInter.start > currInter.start ? currInter.start
						: indexInter.start;
				indexInter.end = indexInter.end > currInter.end ? indexInter.end
						: currInter.end;
			}
		}
		rtnArray.add(indexInter);
		return rtnArray;
	}
}
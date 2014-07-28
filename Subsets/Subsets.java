public class Solution {
	public static List<List<Integer>> subsets(int[] S) {
	    Arrays.sort(S);
		List<List<Integer>> rtn = new ArrayList<List<Integer>>();
		List<Integer> inList = new ArrayList<Integer>();
		if (S.length == 0)
			return rtn;
		if (S.length == 1) {
			inList.add(S[0]);
			rtn.add(inList);
			rtn.add(new ArrayList<Integer>());
			return rtn;
		}
		int last = S[S.length - 1];
		int[] sub = Arrays.copyOfRange(S, 0, S.length - 1);
		List<List<Integer>> subList = subsets(sub);
		return merge(subList, last, S.length);
	}

	public static List<List<Integer>> merge(List<List<Integer>> list, int last, int length) {
		List<List<Integer>> list2 = new ArrayList<List<Integer>>();
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(last);
		list2.add(l2);
		for (List<Integer> l : list) {
			list2.add(l);
			if (l.size() != 0) {
				l2 = new ArrayList<Integer>();
				l2.addAll(l);
				l2.add(last);
				list2.add(l2);
			}
		}
		if (list.size() == length - 1)
			list2.add(new ArrayList<Integer>());
		return list2;
	}
}

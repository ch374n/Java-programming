import java.util.List;
import java.util.ArrayList;

public class Optimal extends PageReplacement{
	private int INFINITY =  Integer.MAX_VALUE;

	public void execute() {
		init();
		float hit = 0;
		for(int i = 0; i < numEntries; i++) {
			List<String> frame = new ArrayList<>();
			List<Integer> dist = distance.get(i);
			if (i > 0) {
				frame = new ArrayList<>(pageFrames.get(i - 1));
				dist  = new ArrayList<>(distance.get(i - 1));
			}

			if(!frame.contains(pageTrace[i])) {
				if(frame.size() == numFrames) {	
					int in = replace(dist, frame);
					frame.set(in, pageTrace[i]);
				} else {
					frame.add(pageTrace[i]);
				}
			} else {
				hit += 1;
				int index = frame.indexOf(pageTrace[i]);
			}

			forwardDistance(dist, i, frame);								
			pageFrames.add(frame);
			distance.set(i, dist);
		}
		display(hit);
	}

	public void forwardDistance(List<Integer> dist, int index, List<String> frame) {
		for(int j = 0; j < frame.size(); j++) {
			boolean flag = false;
			for(int i = index + 1; i < numEntries; i++) { 				
					if(frame.get(j).equals(pageTrace[i])) {
						dist.set(j, i - index);
						flag = true;
						break;
					}
			}
			if(!flag) {
				dist.set(j, INFINITY);
			}
		}
	}

	public int replace(List<Integer> dist, List<String> frame) {
		int max = dist.get(0);
		int index = 0;
		for(int i = 0; i < dist.size(); i++) {
			if (max < dist.get(i)) {
				max   = dist.get(i);
				index = i;
			}
		}
		return index;
	}

}
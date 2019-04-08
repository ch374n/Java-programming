import java.util.List;
import java.util.ArrayList;

public class LRU extends PageReplacement{

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
					int index = frame.indexOf(pageTrace[i]);
					modify(dist, index);				
				}
			} else {
				hit += 1;
				int index = frame.indexOf(pageTrace[i]);
				modify(dist, index);								
			}

			pageFrames.add(frame);
			distance.set(i, dist);
		}	

		display(hit);
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
		modify(dist, index);
		return index;
	}

	public void modify(List<Integer> dist, int index) {
		for(int i = 0; i < numFrames; i++) {
			if(i == index) { 
			  	dist.set(i, 0);
			} else if(dist.get(i) != -1) {
				dist.set(i, dist.get(i) + 1);
			}
		}
	}	
}
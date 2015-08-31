package string;

public class FullJustify {
	 public List<String> fullJustify(String[] words, int maxWidth) {
	        List<String> res = new ArrayList<String>();
	        if (words == null || words.length == 0) {
	            return res;
	        }
	        
	        int count = 0;
	        int last = 0;
	        
	        for (int i = 0; i < words.length; i++) {
	            if (count + words[i].length() + i - last > maxWidth) {
	                int space = 0;
	                int extra = 0;
	                
	                if (i - 1 - last > 0) {
	                    space = (maxWidth - count) / (i - 1 - last);
	                    extra = (maxWidth - count) % (i - 1 - last);
	                }
	                
	                StringBuilder sb = new StringBuilder();
	                for (int j = last; j < i; j++) {
	                    sb.append(words[j]);
	                    
	                    if (j < i - 1) {
	                        for (int k = 0; k < space; k++) {
	                            sb.append(' ');
	                        }
	                        
	                        if (extra > 0) {
	                            sb.append(' ');
	                            extra--;
	                        }
	                    }
	                }
	                
	                for (int j = sb.length(); j < maxWidth; j++) {
	                    sb.append(' ');
	                }
	                
	                res.add(sb.toString());
	                count = 0;
	                last = i;
	            }
	            count += words[i].length();
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        
	        for (int i = last; i < words.length; i++) {
	            sb.append(words[i]);
	            if (sb.length() < maxWidth) {
	                sb.append(' ');
	            }
	        }
	        
	        for (int i = sb.length(); i < maxWidth; i++) {
	            sb.append(' ');
	        }
	        
	        res.add(sb.toString());
	        
	        return res;
	    }
}

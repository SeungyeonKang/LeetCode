class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        // M : length of products
        // N : length of searchWord
        // Time Complexity = O(MlogM) + O(NM)
        // Space Complexity = O(M+N)
        
        List<List<String>> results = new ArrayList<>();
        if (products == null || products.length == 0 || searchWord == null || searchWord.isEmpty()) {
            return results;
        }
        Arrays.sort(products); // O(M logM)
        
        List<String> productList = new ArrayList();
        for(String product: products) {
            productList.add(product);
        } //O(M)
        
        for(int i=0; i<searchWord.length(); i++){ //O(N)
            char c = searchWord.charAt(i);
            List<String> filteredList = new ArrayList<>();
            
            for(String product: productList){ //O(M)
                if(i < product.length() && c == product.charAt(i)) {
                    filteredList.add(product);
                }
            }
            
            List<String> tmp = new ArrayList<>();
            for(int j=0; j<3 && j<filteredList.size(); j++){
                tmp.add(filteredList.get(j));
            }
            
            results.add(tmp);
            productList = filteredList;
        }
        
        return results;
    }
}

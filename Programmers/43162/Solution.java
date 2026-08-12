// 노드 하나씩 가져온다
// 현재 노드 빼고, 연결된 노드로 이동
// 방문 노드는 방문했다고 표시
// 네트워크 카운트 증가

class Solution {
    public int n;
    public int[][] computers;
    public boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        this.visited = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }
        return answer;
    }
    
    public void dfs(int now) {
        visited[now] = true;
        
        for (int next = 0; next < n; next++) {
            if (computers[now][next] == 1 && !visited[next]) {
                dfs(next);
            }
        }
    }
}

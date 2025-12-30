class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        
        d_q = deque()
        r_q = deque()

        for i, s in enumerate(senate):
            if s == "R":
                r_q.append(i)
            else:
                d_q.append(i)

        while r_q and d_q:

            r = r_q.popleft()
            d = d_q.popleft()

            if r < d:
                r_q.append(r+len(senate))
            else:
                d_q.append(d+len(senate))

        if r_q:
            return "Radiant"
        else:
            return "Dire"   



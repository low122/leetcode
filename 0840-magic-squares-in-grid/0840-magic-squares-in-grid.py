class Solution:
    def numMagicSquaresInside(self, grid: List[List[int]]) -> int:
        
        m, n = len(grid), len(grid[0])
        ans = 0

        def is_magic(r,c):

            if grid[r+1][c+1] != 5:
                return False

            val = [grid[r+i][c+j] for i in range(3) for j in range(3)]

            if len(set(val)) != 9:
                return False

            for i in val:
                if i not in range(1,10):
                    return False
            

            target = grid[r][c] + grid[r][c+1] + grid[r][c+2]

            # Rows
            if (grid[r + 1][c] + grid[r + 1][c + 1] + grid[r + 1][c + 2]) != target:
                return False
            if (grid[r + 2][c] + grid[r + 2][c + 1] + grid[r + 2][c + 2]) != target:
                return False

            # Columns
            if (grid[r][c] + grid[r + 1][c] + grid[r + 2][c]) != target:
                return False
            if (grid[r][c + 1] + grid[r + 1][c + 1] + grid[r + 2][c + 1]) != target:
                return False
            if (grid[r][c + 2] + grid[r + 1][c + 2] + grid[r + 2][c + 2]) != target:
                return False

            # Diagonals
            if (grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2]) != target:
                return False
            if (grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c]) != target:
                return False

            return True

        for r in range(m-2):
            for c in range(n-2):
                if is_magic(r,c):
                    ans += 1
        return ans
class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        vowel = {'a','e','i','o','u'}

        total: int = 0
        left: int = 0
        result: int = 0

        for right in range(len(s)):

            if s[right] in vowel:
                total += 1

            # Adjusting the window size
            if right - left + 1 > k:
                if s[left] in vowel:
                    total -= 1
                left += 1

            # Only responsible for updating result
            if right - left + 1 == k:
                result = max(total, result)


        return result
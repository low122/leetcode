class Solution:
    def compress(self, chars: List[str]) -> int:
        
        write = 0
        i = 0

        while i < len(chars):

            count = 1
            curr_char = chars[i]

            while i + 1 < len(chars) and chars[i] == chars[i+1]:
                count += 1
                i += 1

            chars[write] = curr_char
            write += 1

            if count > 1:
                for digit_char in str(count):
                    chars[write] = digit_char
                    write += 1

            i += 1

        return write

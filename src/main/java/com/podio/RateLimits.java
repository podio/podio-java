package com.podio;

public class RateLimits {
    
        private static int limit;
        private static int remaining;

        public static int getLimit() {
                return limit;
        }

        public static void setLimit(int limit) {
                RateLimits.limit = limit;
        }

        public static int getRemaining() {
                return remaining;
        }

        public static void setRemaining(int remaining) {
                RateLimits.remaining = remaining;
        }
    
}

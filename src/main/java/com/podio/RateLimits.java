package com.podio;

public class RateLimits {

        private static Integer limit;
        private static Integer remaining;

        /**
         * Returns the ceiling for the request you just made. May be null if
         * there is no limit.
         *
         * @return the ceiling for the request you just made
         */
        public static Integer getLimit() {
                return limit;
        }

        public static void setLimit(Integer limit) {
                RateLimits.limit = limit;
        }

        /**
         * Returns the number of requests you have left for the current 1 hour
         * window. May be null if there is no limit.
         *
         * @return the number of requests you have left for the current 1 hour
         * window
         */
        public static Integer getRemaining() {
                return remaining;
        }

        public static void setRemaining(Integer remaining) {
                RateLimits.remaining = remaining;
        }

}

(ns adventofcode-2020.day5-test
  (:require [adventofcode-2020.day5 :refer :all]
            [clojure.test :refer :all]))

(def fixture {"FBFBBFFRLR" {:row 44 :col 5 :id 357}
              "BFFFBBFRRR" {:row 70 :col 7 :id 567}
              "FFFBBBFRRR" {:row 14 :col 7 :id 119}
              "BBFFBBFRLL" {:row 102 :col 4 :id 820}})


(deftest test-parse-row
  (doseq [[boarding data] fixture]
    (is (= (:row data) (parse-row (take 7 boarding))))))

(deftest test-parse-column
  (doseq [[boarding data] fixture]
    (is (= (:col data) (parse-column (drop 7 boarding))))))

(deftest test-seat-id
  (doseq [[boarding data] fixture]
    (is (= (:id data) (seat-id boarding)))))

(deftest test-missing-seat
  (let [fixture {4 [1 2 3 5 6]
                 2 [1 3 4 5 6]
                 5 [1 2 3 4 6]
                 nil [1 2 3 4 5 6]}]
    (doseq [[n seats] fixture]
      (is (= n (missing-seat (shuffle seats)))))))

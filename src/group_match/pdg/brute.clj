(ns group-match.pdg.brute
  (:require [clojure.math.combinatorics :as combo]))

;; Just some ideas here.

;; Given a group of 20 students
(def students (vec (range 20)))

;; And the number of groups we need to make
(def group-num 5)

;; Get a list of all the combinations for referenc
(def all-combinations (combo/combinations students group-num))
(def all-pairs (combo/combinations students 2))

(comment
  
  (def group-partitions (map vec (partition group-num students)))

  ;; There's a cool trick you can do by mapping vector onto a bunch of seqs
  ;;   - it takes the first of every seq, the second of every seq, etc
  ;; since `partition` is a seq-of-seqs, we'll need to use apply

  (def rotate-partitions (apply map vector group-partitions))

  ;; Really, the more you dive into this, the more you realize it's a logic problem.
  ;; But nonetheless, there's a bruteforce way to solve this
  ;; It lends itself very well to Dynamic Programming as well
  ;;
  ;; One brute force method is to find the unique pairings
  (def pairings (map (comp vec flatten) (combo/combinations all-pairs (quot (quot (count students) group-num) 2))))


  ;; Let's forulate the logic description:
  ;; Give me all combinations where new two items appear in the same group more than once (or twice if we want to be a little looser).

  )

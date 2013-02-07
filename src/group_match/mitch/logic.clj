(ns group-match.mitch.logic
  (:require [clojure.math.numeric-tower :as c_tower]
            [clojure.core.logic.fd :as c_fd])
  (:refer-clojure :exclude [==])
  (:use [clojure.core.logic]))

;; My (Mitch Thomas') first attempt at using core.logic... WOOT!

;; Give me all combinations where new two items appear in the same group more than once (or twice if we want to be a little looser).
;; (def classes [:C1 :C2 :C3])
;; (def students [:F :L :J :M]
;; Possible answer
;; C1: (F L) (J M)
;; C2: (F J) (M L)
;; C3: (F M) (J L)

;; taken from https://github.com/ejackson/EuroClojure-2012-Talk/blob/master/src/timetable/demo.clj
(defne permo
  "Succeeds if x1 is a permutation of x2."
  [v1 v2]
  ([[] []])
  ([[h . t] v2]
     (fresh [rv2]
            (membero h v2)
            (rembero h v2 rv2)
            (permo t rv2))))

;; taken from https://github.com/ejackson/EuroClojure-2012-Talk/blob/master/src/timetable/demo.clj
(defne subseto
  "Succeeds if x1 is a subset of x2.  x1 is distinct with elements of x2 but is shorter than or equal to x2"
  [x1 x2]
  ([[] _])
  ([[a . r] x2]
     (fresh [rx2]
            (membero a x2)
            (rembero a x2 rx2)
            (subseto r rx2))))

;; I forgot where I got this
(defne partitiono [a b c d]
  ([[x . l] _ [x . l1] _]
     (conda
       ((project [x b]
          (== (<= x b) true))
        (partition l b l1 d))
       (partition l b c d))))

;; matche is great, check this out
;; https://github.com/frenchy64/Logic-Starter/wiki

;; Attempt to re-state the problem space in terms of goals  
;; given a total set of students
;; create unique subsets of the total set of students
;; whose size should be an equal division of the total set of students
;; where unique is defined as
;;  a student can not be in the same group twice (distincto)
;;  no pairing of students is the same as the last pairing of students

(def students [:Finley :Lark :Julie :Mitch :Gary :Jim :Yvonne :Elaine :A :B :C :D :E :F :G :H :I :J :K :L :M])

;; Successfull for any even divisions of ct
(defne even-groupo [ct out]
  ([]
     (fresh [x y]
         (c_fd/in x (c_fd/interval 2 ct))
         (c_fd/in y (c_fd/interval 2 ct))
         (c_fd/* x y ct)
         (== out x))))

(comment
  (run 40 [out]
       (subseto out students)
       (matche [out]
               ([[_ _ _]] succeed)))

  (let [ct (count students)]
      (run* [q] (even-groupo ct q)))

)

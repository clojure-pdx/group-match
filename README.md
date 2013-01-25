group-match
===========

Group match provides a single function, `group-match` that:

 * Takes a list of elements (students - represented as ints, strings, keywords, whatever) [20]
 * Takes a number of groups to form [5]
 * Takes a number of projects [8]
 * Returns a vector of vectors - the groups for each project, with the least amount of repeat pairings

A pairing is when two students appear in a group together.  We're trying to avoid (best case) or minimize (worse case) pairings.

Usage
-----

### From the command-line
TBD but should be `lein run`

### From the web site
Let's build out a small web app that let's you do this.
Optionally, we can add functions to accept the list of students via csv or from a file (split on newline).

License
-------

Copyright © 2013 Clojerks

Distributed under the Eclipse Public License, the same as Clojure.


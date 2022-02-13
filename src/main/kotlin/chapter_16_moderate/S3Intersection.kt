package chapter_16_moderate

import java.awt.Point
import kotlin.math.max
import kotlin.math.min

class S3Intersection {
    // Given three collinear points p, q, r, the function checks if point q lies on line segment 'pr'
    private fun onSegment(p: Point, q: Point, r: Point): Boolean {
        return q.x <= max(p.x, r.x) &&
                q.x >= min(p.x, r.x) &&
                q.y <= max(p.y, r.y) &&
                q.y >= min(p.y, r.y)
    }

    // To find orientation of ordered triplet (p, q, r).
    // The function returns following values
    // 0 --> p, q and r are collinear
    // 1 --> Clockwise
    // 2 --> Counterclockwise
    private fun orientation(p: Point, q: Point, r: Point): Int {
        val value = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y)
        if (value == 0) return 0 // collinear
        return if (value > 0) 1 else 2 // clock or counter-clockwise
    }

    // The main function that returns true if line segment 'p1q1' and 'p2q2' intersect.
    private fun doIntersect(p1: Point, q1: Point, p2: Point, q2: Point): Boolean {
        // Find the four orientations needed
        val o1 = orientation(p1, q1, p2)
        val o2 = orientation(p1, q1, q2)
        val o3 = orientation(p2, q2, p1)
        val o4 = orientation(p2, q2, q1)

        return when {
            // General case
            o1 != o2 && o3 != o4 -> true
            //Special cases
            o1 == 0 && onSegment(p1, p2, q1) -> true // p1, q1 and p2 are collinear and p2 lies on segment p1q1
            o2 == 0 && onSegment(p1, q2, q1) -> true // p1, q1 and q2 are collinear and q2 lies on segment p1q1
            o3 == 0 && onSegment(p2, p1, q2) -> true // p2, q2 and p1 are collinear and p1 lies on segment p2q2
            o4 == 0 && onSegment(p2, q1, q2) -> true // p2, q2 and q1 are collinear and q1 lies on segment p2q2
            else -> false
        }
    }

    fun runTest() {
        var p1 = Point(1, 1)
        var q1 = Point(10, 1)
        var p2 = Point(1, 2)
        var q2 = Point(10, 2)
        if (doIntersect(p1, q1, p2, q2)) println("Yes") else println("No")
        p1 = Point(10, 1)
        q1 = Point(0, 10)
        p2 = Point(0, 0)
        q2 = Point(10, 10)
        if (doIntersect(p1, q1, p2, q2)) println("Yes") else println("No")
        p1 = Point(-5, -5)
        q1 = Point(0, 0)
        p2 = Point(1, 1)
        q2 = Point(10, 10)
        if (doIntersect(p1, q1, p2, q2)) println("Yes") else println("No")
    }
}
WITH UserRatings AS (
    SELECT user_id, COUNT(*) AS rating_count
    FROM MovieRating
    GROUP BY user_id
),
TopUser AS (
    SELECT u.name
    FROM Users u
    JOIN UserRatings ur ON u.user_id = ur.user_id
    ORDER BY ur.rating_count DESC, u.name ASC
    LIMIT 1
),
MovieAvgRatings AS (
    SELECT mr.movie_id, m.title, AVG(mr.rating) AS avg_rating
    FROM MovieRating mr
    JOIN Movies m ON mr.movie_id = m.movie_id
    WHERE mr.created_at BETWEEN '2020-02-01' AND '2020-02-29'
    GROUP BY mr.movie_id, m.title
),
TopMovie AS (
    SELECT title
    FROM MovieAvgRatings
    ORDER BY avg_rating DESC, title ASC
    LIMIT 1
)
SELECT (SELECT name FROM TopUser) AS results
UNION ALL
SELECT (SELECT title FROM TopMovie);

SELECT id, COUNT(DISTINCT friend) AS num
FROM (
    SELECT requester_id AS id, accepter_id AS friend
    FROM RequestAccepted
    UNION
    SELECT accepter_id AS id, requester_id AS friend
    FROM RequestAccepted
) AS friends
GROUP BY id
HAVING num = (SELECT MAX(num) FROM (SELECT COUNT(DISTINCT friend) AS num
                                     FROM (
                                         SELECT requester_id AS id, accepter_id AS friend
                                         FROM RequestAccepted
                                         UNION
                                         SELECT accepter_id AS id, requester_id AS friend
                                         FROM RequestAccepted
                                     ) AS friends
                                     GROUP BY id) AS max_friends)
ORDER BY id;

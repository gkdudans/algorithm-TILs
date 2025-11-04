SELECT 
    u.user_id as USER_ID, 
    u.nickname as NICKNAME, 
    SUM(b.price) AS TOTAL_SALES
FROM used_goods_user u
JOIN used_goods_board b 
    ON u.user_id = b.writer_id
WHERE b.status = 'DONE'
GROUP BY u.user_id, u.nickname
HAVING SUM(b.price) >= 700000
ORDER BY TOTAL_SALES;

CREATE TABLE schedules (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- 고유 식별자 (자동 증가)
    task TEXT NOT NULL,                 -- 할 일 (필수)
    username VARCHAR(100) NOT NULL,       -- 작성자명 (필수)
    password VARCHAR(255) NOT NULL,     -- 비밀번호 (필수)
    created_at DATETIME DEFAULT NOW(),  -- 작성일 (자동 입력)
    updated_at DATETIME DEFAULT NOW() ON UPDATE NOW() -- 수정일 (자동 업데이트)
);


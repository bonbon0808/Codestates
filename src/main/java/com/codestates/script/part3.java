package com.codestates.script;

public class part3 {
  /*
  ----------------------------------------------------------------------------------------------
      TODO: 유어클래스의 requirement를 참조하여, migration/schema.sql에 추가로 구성해주세요.
  */

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-1-1. category 테이블의 구조를 보기위한 SQL을 작성해주세요.
          - 요구사항에 맞는 category 테이블을 작성해야만, 테스트를 통과합니다.
  */
  public static final String PART3_1_1 = "DESCRIBE category";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-1-2. content_category 테이블의 구조를 보기위한 SQL을 작성해주세요.
          - 요구사항에 맞는 content_category 테이블을 작성해야만, 테스트를 통과합니다.
  */
  public static final String PART3_1_2 = "DESCRIBE content_category";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-1-3. role 테이블의 구조를 보기위한 SQL을 작성해주세요.
          - 요구사항에 맞는 role 테이블을 작성해야만, 테스트를 통과합니다.
  */
  public static final String PART3_1_3 = "DESCRIBE role";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-1-4. user 테이블의 구조를 보기위한 SQL을 작성해주세요.
          - 요구사항에 맞는 user 테이블을 작성해야만, 테스트를 통과합니다.
  */
  public static final String PART3_1_4 = "DESCRIBE user";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-2-1. category 테이블에 존재하는 데이터에서 id, name을 찾는 SQL을 작성해주세요.
  */

  public static final String PART3_2_1 = "SELECT c.id, c.name FROM category As c";

          //"SELECT * FROM category";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-2-2. user의 name과 email 그리고 그 user가 속한 role name(컬럼명: roleName)을 찾기 위한 SQL을 작성해주세요.
          - 속한 role이 없더라도, user의 name과 email,role name을 모두 찾아야합니다. AS
  */
  public static final String PART3_2_2 = "SELECT u.name, u.email, r.name As roleName " +
          "From user As u " +
          "LEFT JOIN role As r ON u.roleId = r.id ";

  //"SELECT user.name, user.email, role.name As roleName From user LEFT JOIN role ON user.roleId = role.id";


  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-2-3. 어느 role에도 속하지 않는 user의 모든 컬럼 데이터를 찾기위한 SQL을 작성해주세요.
  */
  public static final String PART3_2_3 = "SELECT * " +
          "From user As u " +
          "LEFT JOIN role As r ON u.roleId = r.id " +
          "WHERE r.id IS NULL ";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-2-4. content_category 테이블에 존재하는 모든 칼럼의 데이터를 찾기위한 SQL을 작성해주세요.
  */
  public static final String PART3_2_4 = "SELECT * FROM content_category";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-2-5. minsanggu이 작성한 content의 title을 찾기위한 SQL을 작성해주세요.
  */
  public static final String PART3_2_5 = "SELECT c.title " +
          "FROM content As c " +
          "JOIN user As u ON c.userId = u.id " +
          "WHERE u.name = 'minsanggu' ";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-2-6. minsanggu이 작성한 content의 category name을 찾기위한 SQL을 작성해주세요.
  */
  public static final String PART3_2_6 = "SELECT cg.name " +
          "FROM category As cg " +
          "JOIN content_category As cc ON cc.categoryId = cg.id " +
          "JOIN content As c ON c.id = cc.contentId " +
          "JOIN user As u ON c.userId = u.id " +
          "WHERE u.name = 'minsanggu' ";


  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-2-7. category의 name이 java인 content의 title, body, created_at을 찾기위한 SQL을 작성해주세요.
  */
  public static final String PART3_2_7 = "SELECT c.title, c.body, c.created_at " +
          "FROM content AS c " +
          "JOIN content_category AS cc ON c.id = cc.contentId " +
          "JOIN category AS cg ON cg.id = cc.categoryId " +
          "WHERE cg.name = 'java' ";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-2-8. category의 name이 java인 content의 title, body, created_at, user의 name을 찾기위한 SQL을 작성해주세요.
  */
  public static final String PART3_2_8 = "SELECT c.title, c.body, c.created_at, u.name " +
          "FROM content As c " +
          "JOIN user AS u ON c.userID = u.id " +
          "JOIN content_category AS cc ON c.id = cc.contentId " +
          "JOIN category AS cg ON cc.categoryId = cg.id " +
          "WHERE cg.name = 'java' ";
  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-2-9. teawoongna가 작성한 글의 개수 (컬럼명: ContentCount)를 출력하기 위한 SQL을 작성해주세요.
  */
  public static final String PART3_2_9 = "SELECT COUNT(c.id) AS ContentCount " +
          "FROM content AS c " +
          "JOIN user AS u ON u.id = c.userId " +
          "WHERE u.name = 'teawoongna' ";


  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-2-10. 각 user(컬럼명: name)가 작성한 글의 개수 (컬럼명: ContentCount)를 출력하기 위한 SQL을 작성해주세요.
  */
  public static final String PART3_2_10 = "SELECT u.name, COUNT(c.id) AS ContentCount " +
          "FROM user AS u " +
          "LEFT JOIN content As c ON u.id = c.userID " +
          "GROUP BY u.name ";
}

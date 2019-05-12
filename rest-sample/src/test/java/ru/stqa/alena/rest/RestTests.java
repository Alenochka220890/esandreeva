package ru.stqa.alena.rest;

import com.google.gson.Gson;
        import com.google.gson.JsonElement;
        import com.google.gson.JsonParser;
        import com.google.gson.reflect.TypeToken;
        import org.apache.http.client.fluent.Executor;
        import org.apache.http.client.fluent.Request;
        import org.apache.http.message.BasicNameValuePair;
        import org.testng.annotations.Test;
        import ru.stqa.alena.rest.Issue;
        import java.io.IOException;
        import java.util.Set;

        import static org.testng.Assert.assertEquals;

public class RestTests {


  /**
   * Тест проверяет создание багрепорта по протоколу REST
   */
  @Test
  public void testCreateIssue() throws IOException {
    Set<Issue> oldIssues = getIssues();
    Issue newIssue = new Issue().withSubject("Alena Test").withDescription("Alena description");
    int issueId = createIssue(newIssue);

    Set<Issue> newIssues = getIssues();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);

  }

  /**
   * Метод получает список багрепортов в формате json с помощью GET запроса
   *
   * @return множестсво объектов типа Issue
   */
  private Set<Issue> getIssues() throws IOException {
    String json = getExecutor().execute(Request.Get("http://bugify.stqa.ru/api/issues.json?limit=500"))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {}.getType());
  }

  /**
   * Технический метод для авторизации на сервере
   */
  private Executor getExecutor() {
    return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490", "");
  }

  /**
   * Метод создаёт новый багрепорт с помощью POST запроса
   * @return id созданного багрепорт
   */
  private int createIssue(Issue newIssue) throws IOException {
    String json = getExecutor().execute(Request.Post("http://bugify.stqa.ru/api/issues.json")
            .bodyForm(new BasicNameValuePair("subject", newIssue.getSubject()),
                    new BasicNameValuePair("description", newIssue.getDescription()))).returnContent().asString();


    JsonElement parsed = new JsonParser().parse(json);
    return parsed.getAsJsonObject().get("issue_id").getAsInt();

  }

}

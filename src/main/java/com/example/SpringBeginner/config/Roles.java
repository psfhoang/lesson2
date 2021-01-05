package com.example.SpringBeginner.config;

import java.util.ArrayList;
import java.util.List;

public class Roles {
  public static List<String> admin = new ArrayList<>();
  public static List<String> vip1 = new ArrayList<>();
  static {
      admin.add(Authority.AUTHORITY_FULL);
      admin.add(Authority.AUTHORITY_ADD_BOOKS);
      admin.add(Authority.AUTHORITY_ADD_AUTHORS);
      admin.add(Authority.AUTHORITY_DELETE_BOOKS);
      admin.add(Authority.AUTHORITY_DELETE_AUTHORS);
      admin.add(Authority.AUTHORITY_UPDATE_BOOKS);
      admin.add(Authority.AUTHORITY_UPDATE_AUTHORS);

      vip1.add(Authority.AUTHORITY_UPDATE_AUTHORS);
  }
}

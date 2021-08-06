package com.laptrinhjavaweb.controller.output;

import com.laptrinhjavaweb.dto.NewDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class NewOutput {
  private int page;
  private int totalPage;
  private List<NewDTO> listResult = new ArrayList<>();

 }

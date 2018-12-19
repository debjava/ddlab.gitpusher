/*
 * Copyright 2018 Tornado Project from DDLAB Inc. or its subsidiaries. All Rights Reserved.
 */
package com.ddlab.gitpusher.core;

/**
 * The Interface IGistResponseParser.
 *
 * @author Debadatta Mishra
 * @param <IN> the generic type
 * @param <OUT> the generic type
 */
public interface IGistResponseParser<IN, OUT> {

  /**
   * Parses the.
   *
   * @param in the in
   * @return the out
   * @throws Exception the exception
   */
  OUT parse(IN in) throws Exception;
}

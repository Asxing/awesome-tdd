/*-
 * -\-\-
 * hamcrest-future
 * --
 * Copyright (C) 2016 Spotify AB
 * --
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -/-/-
 */

package com.holddie.future;

import static com.holddie.future.FutureMatchers.futureCompletedWithException;
import static com.holddie.future.FutureMatchers.futureCompletedWithExceptionThat;
import static com.holddie.future.FutureMatchers.futureCompletedWithValue;
import static com.holddie.future.FutureMatchers.futureCompletedWithValueThat;
import static com.holddie.future.FutureMatchers.futureWillCompleteWithException;
import static com.holddie.future.FutureMatchers.futureWillCompleteWithExceptionThat;
import static com.holddie.future.FutureMatchers.futureWillCompleteWithValue;
import static com.holddie.future.FutureMatchers.futureWillCompleteWithValueThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Future;
import org.junit.Test;

public class FutureMatchersTest {

  @Test
  public void exceptional() {
    final RuntimeException ex = new RuntimeException("oops");

    final Future<String> cf = Futures.immediateFailedFuture(ex);

    assertThat(cf, futureCompletedWithException());
    assertThat(cf, futureCompletedWithExceptionThat(is(sameInstance(ex))));
    assertThat(cf, futureCompletedWithExceptionThat(isA(RuntimeException.class)));
    assertThat(cf, futureWillCompleteWithException());
    assertThat(cf, futureWillCompleteWithExceptionThat(is(sameInstance(ex))));
    assertThat(cf, futureWillCompleteWithExceptionThat(isA(RuntimeException.class)));
  }

  @Test
  public void success() {
    final Future<String> cf = Futures.immediateFuture("hi");

    assertThat(cf, not(futureCompletedWithException()));
    assertThat(cf, not(futureCompletedWithExceptionThat(isA(Throwable.class))));
    assertThat(cf, futureCompletedWithValue());
    assertThat(cf, futureCompletedWithValueThat(not(nullValue())));
    assertThat(cf, futureCompletedWithValueThat(notNullValue()));
    assertThat(cf, futureCompletedWithValueThat(equalTo("hi")));

    assertThat(cf, not(futureWillCompleteWithException()));
    assertThat(cf, not(futureWillCompleteWithExceptionThat(isA(Throwable.class))));
    assertThat(cf, futureWillCompleteWithValue());
    assertThat(cf, futureWillCompleteWithValueThat(not(nullValue())));
    assertThat(cf, futureWillCompleteWithValueThat(notNullValue()));
    assertThat(cf, futureWillCompleteWithValueThat(equalTo("hi")));
  }
}

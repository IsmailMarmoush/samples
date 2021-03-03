package com.marmoush.javasamples.java8.OCP.chp11;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchServiceExample {
  public static void main(String[] args) throws IOException {
    try (WatchService service = FileSystems.getDefault().newWatchService()) {
      // Register for events
      Path zooData = Paths.get("/user/home/zoo/data");
      Path zooLog = Paths.get("/user/home/zoo/log");
      zooData.register(service,
                       StandardWatchEventKinds.ENTRY_CREATE,
                       StandardWatchEventKinds.ENTRY_DELETE,
                       StandardWatchEventKinds.ENTRY_MODIFY);
      zooLog.register(service, StandardWatchEventKinds.ENTRY_MODIFY);
      // Poll for events
      for (; ; ) {
        WatchKey key;
        try {
          key = service.take();
        } catch (InterruptedException x) {
          break;
        }
        // Retrieve events for key
        for (WatchEvent<?> event : key.pollEvents()) {
          WatchEvent.Kind<?> kind = event.kind();
          if (kind == StandardWatchEventKinds.OVERFLOW) {
            continue;
          }
          // Process event
          WatchEvent<Path> watchEvent = (WatchEvent<Path>) event;
          Path path = watchEvent.context();
          System.out.println("[eventType=" + kind + ", path=" + path.getFileName() + "]");
        }
        // Remember to always reset event key
        if (!key.reset()) {
          break;
        }
      }
    }
  }
}

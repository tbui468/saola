/*

package dev.bui.saola;

//@RestController
//@RequestMapping("/api/lessons") //should put the /api in the WebConfig since we need it for everything
public class LessonController {
    private LessonRepository lessonRepo;

    public LessonController(LessonRepository lessonRepo) {
        this.lessonRepo = lessonRepo;
    }

    @GetMapping
    public Iterable<Lesson> all() {
        return this.lessonRepo.findAll();
    }

    @GetMapping("/{id}")
    public Lesson one(@PathVariable Long id) {
        Lesson l = this.lessonRepo.findById(id);

        if (l != null) {
            return l;
        } 

        throw new LessonNotFoundException(id);
    }

    @PostMapping
    public Lesson newLesson(@RequestBody Lesson lesson) {
        return this.lessonRepo.save(lesson);
    }

    @PutMapping("/{id}")
    public Lesson replaceLesson(@RequestBody Lesson lesson, @PathVariable Long id) {
        Lesson l = this.lessonRepo.findById(Long.toString(id));
        if (l != null) {
            //need to replace here
        }

        this.lessonRepo.save(lesson);
        return lesson;
    }

    @DeleteMapping("/{id}")
    public void deleteLesson(@PathVariable Long id) {
        this.lessonRepo.deleteById(Long.toString(id));
    }
}*/

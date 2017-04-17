class CreateCars < ActiveRecord::Migration[5.0]
  def change
    create_table :cars do |t|
      t.string :make
      t.string :color
      t.integer :year

      t.timestamps
    end
  end
end
